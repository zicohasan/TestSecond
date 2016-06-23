package mp.zico.org.sonidrawer;

import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by zico on 22/06/2016.
 */
public class Simple2Fragment extends SimpleFragment {

    public Simple2Fragment() {
        data.add(20F);
        data.add(40F);
        data.add(60F);
        data.add(40F);
        data.add(30F);
        data.add(20F);
        data.add(10F);
    }

    public void next() {
        Fragment fragment = new Simple3Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment).commit();
    }
}
