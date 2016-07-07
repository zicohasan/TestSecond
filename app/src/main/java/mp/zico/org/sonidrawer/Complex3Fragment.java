package mp.zico.org.sonidrawer;

import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by zico on 22/06/2016.
 */
public class Complex3Fragment extends SimpleFragment {

    public Complex3Fragment() {
        data.add(20F);
        data.add(40F);
        data.add(60f);
        data.add(40F);
        data.add(30F);
        data.add(20F);
        data.add(40F);
        data.add(60f);
        data.add(40F);
        data.add(30F);
        data.add(20F);
        data.add(15F);
        data.add(40F);
        data.add(60f);
        data.add(40F);
        data.add(30F);
        data.add(20F);
        data.add(40F);
        data.add(60f);
        data.add(40F);
        data.add(30F);
        data.add(20F);
        data.add(40F);
        data.add(30F);
        data.add(20F);
        data.add(40F);
        data.add(45f);
        data.add(40F);
        data.add(30F);
        data.add(40F);
        data.add(60f);
        data.add(40F);
        data.add(30F);
    }

    public void next() {
        Fragment fragment = new Complex4Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment).commit();
    }
}
