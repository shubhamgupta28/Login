package loginscreen.solution.example.com.loginscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Shubham on 3/24/17.
 */

public class SignUpFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.sign_up, container, false);

        Button bt_create_account = (Button) rootView.findViewById(R.id.bt_sign_up);

        bt_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText name = (EditText) rootView.findViewById(R.id.et_name);
                String sName = name.getText().toString();
                if(sName==null || sName.length() == 0){
                    name.setError("Empty Name");
                }

                EditText email  = (EditText) rootView.findViewById(R.id.et_email);
                String sEmail = name.getText().toString();
                if(sEmail==null || sEmail.length() == 0){
                    email.setError("Empty Name");
                }

                EditText password = (EditText) rootView.findViewById(R.id.et_password);
                String s = password.getText().toString();
                if (!isValidPassword(s)) {
                    password.setError("Invalid Password");
                }

                EditText contactNumber = (EditText) rootView.findViewById(R.id.et_contact_number);
                String sContactNumber = name.getText().toString();
                if(sContactNumber==null || sContactNumber.length() == 0){
                    contactNumber.setError("Empty Name");
                }


            }
        });







        return rootView;

    }

    // validating email id
    private boolean isValidPassword(String email) {
        String EMAIL_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
//
//    // validating password with retype password
//    private boolean isValidPassword(String pass) {
//        if (pass != null && pass.length() > 6) {
//            return true;
//        }
//        return false;
//    }
}
