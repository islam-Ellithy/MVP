package lamaatech.com.mobilestore.Model;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.util.HashMap;
import java.util.Map;

import lamaatech.com.mobilestore.Presenter.MainPresenter;

public class MainModel implements MainContract.IModel {

    private static final String TAG = "Fire";
    private static FirebaseFirestore db;
    private MainContract.IPresenter presenter;

    public MainModel(MainPresenter mainPresenter) {
        presenter = mainPresenter;
        db = FirebaseFirestore.getInstance();
    }

    @Override
    public void makeConfig() {
        db = FirebaseFirestore.getInstance();
    }

    @Override
    public void addDataToFB(String key, String value) {
        // Create a new user with a first and last name
        db = FirebaseFirestore.getInstance();

        Map<String, String> user = new HashMap<>();
        user.put(key, value);
        user.put("middle", "Mathison");
        user.put("last", "Turing");
        //user.put("born", 1912);

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        db.setFirestoreSettings(settings);

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        presenter.onResponse("DocumentSnapshot added with ID: " + documentReference.getId());

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        //Log.w(TAG, "Error adding document", e);
                        presenter.onResponse("Error adding document" + e.getMessage());

                    }
                });
    }


}
