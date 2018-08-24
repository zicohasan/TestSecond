package mp.zico.org.sonidrawerlay;

import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by zico on 22/06/2016.
 */
public class Medium1Fragment extends SimpleFragment {

    public Medium1Fragment() {
        data.add(2F);
        data.add(4F);
        data.add(6F);
        data.add(4F);
        data.add(3F);
        data.add(2F);
        data.add(4F);
/*        data.add(70F);
        data.add(40F);
        data.add(30F);*/
    }

    public void next() {
        Fragment fragment = new Medium2Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment).commit();
    }
}
