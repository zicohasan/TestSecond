package mp.zico.org.sonidrawerlay;

import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by zico on 22/06/2016.
 */
public class Medium3Fragment extends SimpleFragment {

    public Medium3Fragment() {
        data.add(3F);
        data.add(4F);
        data.add(7F);
        data.add(4F);
        data.add(3F);
        data.add(1F);
        data.add(4F);
        data.add(6F);
        data.add(4F);
  /*      data.add(30F);
        data.add(20F);
        data.add(40F);
        data.add(60F);
        data.add(40F);
        data.add(30F);
        data.add(50F);
        data.add(40F);*/
    }

    public void next() {
        Fragment fragment = new Medium1Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment).commit();
    }
}
