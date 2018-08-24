package mp.zico.org.sonidrawerlay;

import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by zico on 22/06/2016.
 */
public class Complex3Fragment extends SimpleFragment {

    public Complex3Fragment() {
        data.add(2F);
        data.add(4F);
        data.add(5f);
        data.add(4F);
        data.add(3F);
        data.add(2F);
        data.add(4F);
        data.add(6f);
        data.add(4F);
        data.add(3F);
        data.add(2F);
       /* data.add(15F);
        data.add(40F);
        data.add(70f);
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
        data.add(30F);*/
    }

    public void next() {
        Fragment fragment = new Complex1Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment).commit();
    }
}
