package mp.zico.org.sonidrawer;

import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by zico on 22/06/2016.
 */
public class Simple4Fragment extends SimpleFragment {

    public Simple4Fragment() {
        data.add(20F);
        data.add(40F);
        data.add(60F);
        data.add(80F);
        data.add(90F);
        data.add(70F);
        data.add(50F);
        data.add(30F);
        data.add(15F);
    }

    public void next() {
        Fragment fragment = new Simple1Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment).commit();
    }
}
