package lamaatech.com.mobilestore.Model;

public class MainContract {

    public interface IModel {
        void makeConfig();

        void addDataToFB(String key, String value);
    }

    public interface IView {

        void onResponse(String status);

    }

    public interface IPresenter {
        void onAddBtnClick();

        void onResponse(String message);
    }
}
