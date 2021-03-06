package com.zte.topsky.weatherdata.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.zte.topsky.chartdata.view.BaseChartView;

import org.xclcharts.chart.CustomLineData;
import org.xclcharts.chart.LineChart;
import org.xclcharts.chart.LineData;
import org.xclcharts.common.DensityUtil;
import org.xclcharts.common.IFormatterDoubleCallBack;
import org.xclcharts.common.IFormatterTextCallBack;
import org.xclcharts.renderer.XEnum;
import org.xclcharts.renderer.info.AnchorDataPoint;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SoilLineChartView extends BaseChartView implements Runnable {
    private String TAG = "LineChart02View";
    private LineChart chart = new LineChart();

    //标签集合
    private LinkedList<String> labels = new LinkedList<>();
    private LinkedList<LineData> chartData = new LinkedList<>();
    private List<CustomLineData> mCustomLineDataset = new LinkedList<>();
    private LinkedList<Double> dataSeries1 = new LinkedList<>();
    private LinkedList<Double> dataSeries2 = new LinkedList<>();
    private Map<String, Double> mSoilData = new LinkedHashMap<>();
    private Map<String, Double> mRelativeData = new LinkedHashMap<>();

    //批注
    List<AnchorDataPoint> mAnchorSet = new ArrayList<>();

    private String mYear;
    private StringBuilder yearly;

    public SoilLineChartView(Context context) {
        super(context);
        initView();
    }

    public SoilLineChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SoilLineChartView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        getNewSoilData(currentYear + "-" + (currentYear + 1), mSoilData);
        getNewRelativeDate(mRelativeData);
        chartLabels();
        chartDataSet();
        chartDesireLines();
        chartRender();
        new Thread(this).start();
        //綁定手势滑动事件
        this.bindTouch(this, chart);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //图所占范围大小
        chart.setChartRange(w, h);
    }

    private void chartRender() {
        try {

            //设置绘图区默认缩进px值,留置空间显示Axis,Axistitle....
            int[] ltrb = getBarLnDefaultSpadding();
            chart.setPadding(DensityUtil.dip2px(getContext(), 45), ltrb[1], ltrb[2], ltrb[3]);


            //设定数据源
            chart.setCategories(labels);
            //	chart.setDataSource(chartData);
            //chart.setCustomLines(mCustomLineDataset);

            chart.getDataAxis().setAxisMin(30);
            //数据轴最大值
            chart.getDataAxis().setAxisMax(100);
            //数据轴刻度间隔
            chart.getDataAxis().setAxisSteps(1);
            //指隔多少个轴刻度(即细刻度)后为主刻度
            chart.getDataAxis().setDetailModeSteps(5);

            //背景网格
            chart.getPlotGrid().showHorizontalLines();

            //标题
            chart.setTitle("土壤、空气湿度情况一览");
            yearly = new StringBuilder("(").append(mYear).append(")");
            chart.addSubtitle(yearly.toString());

            //隐藏顶轴和右边轴
            //chart.hideTopAxis();
            //chart.hideRightAxis();

            //设置轴风格

            //chart.getDataAxis().setTickMarksVisible(false);
            chart.getDataAxis().getAxisPaint().setStrokeWidth(2);
            chart.getDataAxis().getTickMarksPaint().setStrokeWidth(2);
            chart.getDataAxis().showAxisLabels();

            chart.getCategoryAxis().getAxisPaint().setStrokeWidth(2);
            chart.getCategoryAxis().hideTickMarks();

            //定义数据轴标签显示格式
            chart.getDataAxis().setLabelFormatter(new IFormatterTextCallBack() {

                @Override
                public String textFormatter(String value) {
                    // TODO Auto-generated method stub
                    Double tmp = Double.parseDouble(value);
                    DecimalFormat df = new DecimalFormat("#0");
                    String label = df.format(tmp).toString();
                    return (label);
                }

            });


            //定义线上交叉点标签显示格式
            chart.setItemLabelFormatter(new IFormatterDoubleCallBack() {
                @Override
                public String doubleFormatter(Double value) {
                    // TODO Auto-generated method stub
                    DecimalFormat df = new DecimalFormat("#0");
                    String label = df.format(value).toString();
                    return label;
                }
            });

            //chart.setItemLabelFormatter(callBack)

            //允许线与轴交叉时，线会断开
            chart.setLineAxisIntersectVisible(false);

            //chart.setDataSource(chartData);
            //动态线
            chart.showDyLine();

            //不封闭
            chart.setAxesClosed(true);

            //扩展绘图区右边分割的范围，让定制线的说明文字能显示出来
            chart.getClipExt().setExtRight(150.f);

            //设置标签交错换行显示
            chart.getCategoryAxis().setLabelLineFeed(XEnum.LabelLineFeed.ODD_EVEN);

            //仅能横向移动
            chart.setPlotPanMode(XEnum.PanMode.HORIZONTAL);


            //chart.getDataAxis().hide();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.e(TAG, e.toString());
        }
    }

    //计算下平均线
    private double calcAvg() {
        double total = 400d + 480d + 500d + 560d + 800d + 950d + 1200d + 630d + 710d;
        double yearNumber = 9d;

        return (total / yearNumber);
    }

    private void chartDataSet() {
        //Line 1
        for (Double value : mSoilData.values()) {
            dataSeries1.add(value);
        }
        LineData lineData1 = new LineData("土壤湿度(单位：%)", dataSeries1, Color.rgb(234, 83, 71));
        lineData1.setDotStyle(XEnum.DotStyle.DOT);
        lineData1.setLabelVisible(true);

        //Line 2
//        LinkedList<Double> dataSeries2= new LinkedList<Double>();
//        dataSeries2.add(0d);
//        dataSeries2.add(0d);
//        dataSeries2.add(0d);
//        dataSeries2.add(0d);
//        dataSeries2.add((double)800);
//        dataSeries2.add((double)950);
//        dataSeries2.add((double)1200);
//
        for (Double value : mRelativeData.values()) {
            dataSeries2.add(value);
        }
        LineData lineData2 = new LineData("相对湿度(单位：%)", dataSeries2, Color.rgb(75, 166, 51));
        lineData2.setDotStyle(XEnum.DotStyle.PRISMATIC);
        lineData2.getPlotLine().getDotPaint().setColor(Color.rgb(234, 142, 43));
        lineData2.getDotLabelPaint().setColor(Color.rgb(234, 142, 43));
        lineData2.setLabelVisible(true);
        lineData2.getLabelOptions().getBox().getBackgroundPaint().setColor(Color.rgb(76, 76, 76));
        //lineData2.getPlotLabel().hideBox();

        //Line 3
//        LinkedList<Double> dataSeries3= new LinkedList<Double>();
//        dataSeries3.add(0d);
//        dataSeries3.add(0d);
//        dataSeries3.add(0d);
//        dataSeries3.add(0d);
//        dataSeries3.add(0d);
//        dataSeries3.add(0d);
//        dataSeries3.add(0d);
//        dataSeries3.add(630d);
//        dataSeries3.add(710d);
//
//        LineData lineData3 = new LineData("单间(9层无电梯)",dataSeries3,Color.rgb(123, 89, 168));
//        lineData3.setDotStyle(XEnum.DotStyle.DOT);

        //轴上分界线的交叉点
        LinkedList<Double> dataSeries4 = new LinkedList<>();
        dataSeries4.add(1500d);
        LinkedList<Double> dataSeries5 = new LinkedList<>();
        dataSeries5.add(3000d);
        LinkedList<Double> dataSeries6 = new LinkedList<>();
        dataSeries6.add(calcAvg());

        LineData lineData4 = new LineData("", dataSeries4, Color.rgb(35, 172, 57));
        lineData4.setDotStyle(XEnum.DotStyle.RECT);
        LineData lineData5 = new LineData("", dataSeries5, Color.rgb(69, 181, 248));
        lineData5.setDotStyle(XEnum.DotStyle.RECT);
        LineData lineData6 = new LineData("", dataSeries6, Color.rgb(251, 79, 128));
        lineData6.setDotStyle(XEnum.DotStyle.TRIANGLE);

        chartData.add(lineData1);
        chartData.add(lineData2);
//        chartData.add(lineData3);

//        chartData.add(lineData4);
//        chartData.add(lineData5);
//        chartData.add(lineData6);


        //批注
        //List<AnchorDataPoint> mAnchorSet = new ArrayList<AnchorDataPoint>();
//        AnchorDataPoint an4 = new AnchorDataPoint(0, 2, XEnum.AnchorStyle.CAPRECT);
//        an4.setAnchor("批注");
//        an4.setBgColor(Color.rgb(255, 145, 126));
//        mAnchorSet.add(an4);
//        chart.setAnchorDataPoint(mAnchorSet);
    }

    private void chartLabels() {
        for (String key : mSoilData.keySet()) {
            labels.add(key);
        }
    }

    /**
     * 期望线/分界线
     */
    private void chartDesireLines() {
        mCustomLineDataset.add(new CustomLineData("稍好", 1500d, Color.rgb(35, 172, 57), 5));
        mCustomLineDataset.add(new CustomLineData("舒适", 3000d, Color.rgb(69, 181, 248), 5));
        mCustomLineDataset.add(new CustomLineData("[个人均线]", calcAvg(), Color.rgb(251, 79, 128), 6));
    }

    @Override
    public void render(Canvas canvas) {
        try {
            chart.render(canvas);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            chartAnimation();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    private void chartAnimation() {
        try {
            int count = chartData.size();
            for (int i = 0; i < count; i++) {
                Thread.sleep(150);
                LinkedList<LineData> animationData = new LinkedList<>();
                for (int j = 0; j <= i; j++) {
                    animationData.add(chartData.get(j));
                }

                //Log.e(TAG,"size = "+animationData.size());
                chart.setDataSource(animationData);
                if (i == count - 1) {
                    chart.getDataAxis().show();
                    chart.getDataAxis().showAxisLabels();

                    chart.setCustomLines(mCustomLineDataset);
                }
                postInvalidate();
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub

        super.onTouchEvent(event);

        if (event.getAction() == MotionEvent.ACTION_UP) {
            //交叉线
            if (chart.getDyLineVisible()) {
                chart.getDyLine().setCurrentXY(event.getX(), event.getY());
                if (chart.getDyLine().isInvalidate()) this.invalidate();
            }
        }
        return true;
    }

    public Map<String, Double> getNewSoilData(String year, Map<String, Double> data) {
        mYear = year;
        mSoilData = data;
        mSoilData = new LinkedHashMap();
        mSoilData.put("8时", 43d);
        mSoilData.put("9时", 47d);
        mSoilData.put("10时", 52d);
        mSoilData.put("11时", 53d);
        mSoilData.put("12时", 55d);
        mSoilData.put("13时", 64d);
        mSoilData.put("14时", 77d);
        mSoilData.put("15时", 79d);
        mSoilData.put("16时", 82d);
        mSoilData.put("17时", 83d);
        mSoilData.put("18时", 82d);
        return mSoilData;
    }

    private Map<String, Double> getNewRelativeDate(Map<String, Double> data) {
        mRelativeData = data;
        mRelativeData = new LinkedHashMap();
        mRelativeData.put("8时", 57d);
        mRelativeData.put("9时", 58d);
        mRelativeData.put("10时", 60d);
        mRelativeData.put("11时", 61d);
        mRelativeData.put("12时", 63d);
        mRelativeData.put("13时", 69d);
        mRelativeData.put("14时", 85d);
        mRelativeData.put("15时", 88d);
        mRelativeData.put("16时", 91d);
        mRelativeData.put("17时", 93d);
        mRelativeData.put("18时", 91d);
        return mRelativeData;
    }

}

