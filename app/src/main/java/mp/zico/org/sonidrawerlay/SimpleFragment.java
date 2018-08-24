package mp.zico.org.sonidrawerlay;

import android.app.Fragment;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class SimpleFragment extends Fragment implements OnChartValueSelectedListener {

    private LineChart mChart;
    SoundPool mySound;
    int raygunID;
    Entry e;
    MediaPlayer mp;
    Button btn, btn2;
    Vibrator vibrator;


    final private ArrayList<Entry> entries = new ArrayList<Entry>();
    public ArrayList<Float> data = new ArrayList<Float>();

    public abstract void next();

    private void playmp(float a) {
        float volume = ((a / (mChart.getYChartMax() - mChart.getYChartMin())));
        mySound.play(raygunID, 1, 1, 1, 0, volume);

    }
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_simple1, container, false);

        return myView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        mySound = new SoundPool(6, AudioManager.STREAM_NOTIFICATION, 0);
        raygunID = mySound.load(getActivity(), R.raw.p1, 1);
        vibrator = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);

        mChart = (LineChart) getView().findViewById(R.id.chart);
        mChart.setOnChartValueSelectedListener(this);

        ArrayList<String> labels = new ArrayList<String>();

        for (int i = 0; i < data.size(); ++i) {
            entries.add(new Entry(data.get(i), i));
            labels.add(Integer.toString(i));
        }


        LineDataSet dataset = new LineDataSet(entries, "# of Calls");

        LineData data = new LineData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);

        mChart.setData(data);
        mChart.animateY(1000);
        mChart.setScaleEnabled(false);

        btn = (Button) getView().findViewById(R.id.button1);
        mp = MediaPlayer.create(getActivity(), R.raw.p1);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                final Timer timer = new Timer();

                // Body Of Timer
                TimerTask time = new TimerTask() {

                    private int v = 0;

                    @Override
                    public void run() {

                        //Perform background work here
                        if (!mp.isPlaying()) {

                            playmp(entries.get(v++).getVal());


                            if (v >= entries.size())
                                timer.cancel();
                        }


                    }
                };
                //Starting Timer
                timer.scheduleAtFixedRate(time, 0, 500);



            }
        });

        btn2 = (Button) getView().findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
}


    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
        playmp(e.getVal());
        vibrator.vibrate((long) e.getVal()*10);
    }

    @Override
    public void onNothingSelected() {
        playmp(e.getVal());
    }
}