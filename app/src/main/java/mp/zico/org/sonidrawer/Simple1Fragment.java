package mp.zico.org.sonidrawer;

import android.app.Fragment;
import android.app.FragmentTransaction;

import java.util.ArrayList;

/**
 * Created by zico on 22/06/2016.
 */
public class Simple1Fragment extends SimpleFragment {

    public Simple1Fragment() {
        data.add(20F);
        data.add(40F);
        data.add(60F);
        data.add(40F);
        data.add(30F);
        data.add(20F);
    }

    public void next() {
        Fragment fragment = new Simple2Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment).commit();
    }
}
