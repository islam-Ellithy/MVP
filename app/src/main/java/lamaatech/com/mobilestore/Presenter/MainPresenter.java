package lamaatech.com.mobilestore.Presenter;

import lamaatech.com.mobilestore.Model.MainContract;
import lamaatech.com.mobilestore.Model.MainModel;

public class MainPresenter implements MainContract.IPresenter {
    MainContract.IModel model;
    MainContract.IView view;

    public MainPresenter(MainContract.IView newView) {
        view = newView;
        model = new MainModel(this);
    }

    @Override
    public void onAddBtnClick() {
        model.addDataToFB("name", "mohamed");
    }

    @Override
    public void onResponse(String message) {
        view.onResponse(message);
    }
}
