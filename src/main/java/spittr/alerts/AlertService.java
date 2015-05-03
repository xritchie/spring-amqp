package spittr.alerts;

import spittr.domain.Spittle;

/**
 * Created by shawnritchie on 16/04/15.
 */
public interface AlertService {
    void sendSpittleAlert(Spittle spittle);
}
