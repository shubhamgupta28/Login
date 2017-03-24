package loginscreen.solution.example.com.loginscreen;

import android.content.Intent;
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

public class LoginFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.login, container, false);

        Button bt_create_account = (Button) rootView.findViewById(R.id.bt_sign_in);

        bt_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean stop = false;

                EditText email  = (EditText) rootView.findViewById(R.id.et_email);
                String sEmail = email.getText().toString();
                if(sEmail==null || sEmail.length() == 0){
                    email.setError("Empty Name");
                    stop = true;
                }

                EditText password = (EditText) rootView.findViewById(R.id.et_password);
                String s = password.getText().toString();
                if (!isValidPassword(s)) {
                    password.setError("Invalid Password");
                    stop = true;
                }

                if(!stop){
                    Intent intent = new Intent(getActivity(), LoginWelcomeActivity.class);
                    intent.putExtra("email", sEmail);
                    startActivity(intent);

                }


            }
        });


        return rootView;

    }

    private boolean isValidPassword(String email) {
        String EMAIL_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
