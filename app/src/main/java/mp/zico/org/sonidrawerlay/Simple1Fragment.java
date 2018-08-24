package mp.zico.org.sonidrawerlay;

import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by zico on 22/06/2016.
 */
public class Simple1Fragment extends SimpleFragment {

    public Simple1Fragment() {
        data.add(2F);
        data.add(4F);
        data.add(6F);
        data.add(4F);
/*        data.add(30F);
        data.add(20F);*/
    }

    public void next() {
        Fragment fragment = new Simple2Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment).commit();
    }
}
