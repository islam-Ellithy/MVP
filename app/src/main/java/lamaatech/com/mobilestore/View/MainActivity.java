package lamaatech.com.mobilestore.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import lamaatech.com.mobilestore.Model.MainContract;
import lamaatech.com.mobilestore.Presenter.MainPresenter;
import lamaatech.com.mobilestore.R;

public class MainActivity extends AppCompatActivity implements MainContract.IView {

    private MainContract.IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);


    }

    public void onAddNewItemClick(View view) {

        presenter.onAddBtnClick();

    }


    @Override
    public void onResponse(String status) {

        TextView tv = findViewById(R.id.message_tv);

        tv.setText(status);
    }
}
