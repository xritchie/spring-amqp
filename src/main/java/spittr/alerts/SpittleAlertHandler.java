package spittr.alerts;

import spittr.domain.Spittle;

/**
 * Created by shawnritchie on 16/04/15.
 */
public class SpittleAlertHandler {

    public void handleSpittleAlert(Spittle spittle) {
        System.out.println(spittle.getMessage());
    }

}
