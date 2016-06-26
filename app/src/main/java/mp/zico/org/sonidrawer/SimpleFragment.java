package mp.zico.org.sonidrawer;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

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

public abstract class SimpleFragment extends Fragment implements OnChartValueSelectedListener, SeekBar.OnSeekBarChangeListener {

    private LineChart mChart;
    private SeekBar mSeekBar;
    private TextView tvX;
    SoundPool mySound;
    int raygunID;
    Entry e;
    MediaPlayer mp;
    Button btn, btn2;

    final private ArrayList<Entry> entries = new ArrayList<Entry>();
    public ArrayList<Float> data = new ArrayList<Float>();

    public abstract void next();

    private void playmp(float a) {
        float volume = ((a / (mChart.getYChartMax() - mChart.getYChartMin())) * mSeekBar.getProgress());
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
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_simple1);

        //ini adalah load Soundpool
        mySound = new SoundPool(6, AudioManager.STREAM_NOTIFICATION, 0);
        raygunID = mySound.load(getActivity(), R.raw.p1, 1);

        tvX = (TextView) getView().findViewById(R.id.freqChart);

        mSeekBar = (SeekBar) getView().findViewById(R.id.seekBar);
        mSeekBar.setMax(5);
        mSeekBar.setProgress(1);
        mSeekBar.setOnSeekBarChangeListener(this);

        mChart = (LineChart) getView().findViewById(R.id.chart);
        mChart.setOnChartValueSelectedListener(this);

        ArrayList<String> labels = new ArrayList<String>();

        for (int i = 0; i < data.size(); ++i) {
            entries.add(new Entry(data.get(i), i));
            labels.add(Integer.toString(i));
        }
        //for (int i = 0; i < 6; ++i)
        //    entries.add(new Entry(0.1F + (float) Math.random() * 20.0F, i));

        LineDataSet dataset = new LineDataSet(entries, "# of Calls");

        LineData data = new LineData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);

        mChart.setData(data);
        mChart.animateY(1000);

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
                //startActivity(new Intent(SimpleFragment.this, Simple2Activity.class));
            }
        });
//    }
}

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tvX.setText("" + (mSeekBar.getProgress()));
        float volume = ((mChart.getYChartMax() / (mChart.getYChartMax() - mChart.getYChartMin())) * 5);
        //float volume= ((mChart.getY/(mChart.getYChartMax()-mChart.getYChartMin()))*5);
        mySound.play(raygunID, 1, 1, 1, 0, (volume * mSeekBar.getProgress()));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
        playmp(e.getVal());
    }

    @Override
    public void onNothingSelected() {
        playmp(e.getVal());
        //Log.i("Nothing selected", "Nothing selected.");
    }
}