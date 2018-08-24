package mp.zico.org.sonidrawerlay;

import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by zico on 21/06/2017.
 */

public class Simple4Fragment extends SimpleFragment {

    public Simple4Fragment() {
        data.add(1F);
        data.add(2F);
        data.add(3F);
        data.add(4F);
        data.add(5F);
        data.add(6F);
        data.add(7F);
        data.add(8F);
        data.add(9F);
        data.add(10F);
/*        data.add(40F);
        data.add(30F);*/
    }

    public void next() {
        Fragment fragment = new Simple1Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment).commit();
    }
}
