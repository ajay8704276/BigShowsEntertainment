package com.app.bigshows.activity.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.bigshows.BigShowsEntertainmentApp;
import com.app.bigshows.R;
import com.app.bigshows.activity.home.BigShowsHomeActivity;
import com.app.bigshows.model.Login.AuthenticatedToken;
import com.app.bigshows.model.Login.Token;
import com.app.bigshows.model.Login.UserProfileDetail;
import com.app.bigshows.rest.ApiClient;
import com.app.bigshows.rest.login.LoginApiInterface;
import com.app.bigshows.utils.Constants;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Response;


/**
 * Created by Ajay Kumar on 6/30/2016.
 */

public class BIGShowsLoginActivity extends AppCompatActivity implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener,GoogleApiClient.ConnectionCallbacks{



    //TMDB SignUp View
    private EditText  inputEmail, inputPassword;
    private TextInputLayout  inputLayoutEmail, inputLayoutPassword;
    private Button btnSignUp;
    private String userEmail;
    private String userPassword;


    //Google Sign Button
    private SignInButton mGoogleSignInButton;
    private GoogleSignInOptions mSignInOptions;
    private GoogleApiClient mGoogleApiClient;
    private final int GOOGLE_SIGN_IN_REQUEST_CODE = 101;
    private GoogleSignInResult mGoogleSignInResult;





    private Context mContext;

    // Nav drawer View
    private NavigationView mNavigationView;
    private TextView mNavUsertxv;
    private TextView mNavUserEmailtxv;
    private ImageView mNavUserProfilePic;


    //Facebook Login
    private LoginButton mFacebookLoginButton;
    private CallbackManager mCallbackManager;
    private AccessTokenTracker mAccessTokenTracker;
    private ProfileTracker mProfileTracker;



    //Login Api interface
    private LoginApiInterface mLoginApiInterface;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.big_shows_user_login_screen);

        initTMDBViews();


        //init facebook component
        init();


        //initialising nav view before setting the navigation drawer

       /* mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavUsertxv = (TextView) mNavigationView.findViewById(R.id.nav_user_name);
        mNavUserEmailtxv = (TextView) mNavigationView.findViewById(R.id.nav_user_email);
        mNavUserProfilePic = (ImageView) mNavigationView.findViewById(R.id.nav_user_profile_image);*/

        mGoogleSignInButton = (SignInButton) findViewById(R.id.connectWithGoogleButton);
        mFacebookLoginButton = (LoginButton) findViewById(R.id.connectWithFbButton);

        mGoogleSignInButton.setOnClickListener(this);
        mFacebookLoginButton.setOnClickListener(this);

    }

    private void initTMDBViews() {


        inputEmail = (EditText) findViewById(R.id.big_show_user_login_user_email_edittext);
        inputPassword = (EditText) findViewById(R.id.big_show_user_login_user_password_edittext);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.big_show_user_login_user_name_input_layout);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.big_show_user_login_user_password_input_layout);
        btnSignUp = (Button) findViewById(R.id.big_show_user_login_tmdb_signup_tbn);

        inputEmail.addTextChangedListener(new LoginFieldTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new LoginFieldTextWatcher(inputPassword));
        btnSignUp.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_LOGIN);
        Profile profile = Profile.getCurrentProfile();
        displayProfileDetail(profile);
    }


    @Override
    protected void onStop() {
        super.onStop();
        mAccessTokenTracker.stopTracking();
        mProfileTracker.stopTracking();
    }

    private void init() {

        mCallbackManager = CallbackManager.Factory.create();
        mAccessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                // do something on token change
            }
        };

        mProfileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {

                // do something on profile change
                
                displayProfileDetail(currentProfile);
            }
        };

        mAccessTokenTracker.startTracking();
        mProfileTracker.startTracking();

    }

    private void displayProfileDetail(Profile currentProfile) {

        // do something with profile
        if(currentProfile!=null) {
            /*mNavUsertxv.setText(currentProfile.getName().toString());
            mNavUserEmailtxv.setText(currentProfile.getId().toString());*/
            /*String fbUserName = currentProfile.getName();
            String fbUserEmail = currentProfile.getId();*/
        }
    }

    @Override
    public void onClick(View view) {

        if( view == mGoogleSignInButton){

            //Do Google Login
            initGoogleApiClient();

            //Create an intent
            Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);

            //start activity for result;
            startActivityForResult(signInIntent,GOOGLE_SIGN_IN_REQUEST_CODE);



        }else if( view == mFacebookLoginButton){

            //Do Facebook Login
           // mFacebookLoginActivity = new FacebookLoginActivity(mContext);
            //mFacebookLoginButton.registerCallback();
            mFacebookLoginButton.setReadPermissions("user_friends");
            mFacebookLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {

                    AccessToken mAccessToken = loginResult.getAccessToken();
                    Profile mProfile = Profile.getCurrentProfile();
                    displayProfileDetail(mProfile);
                }

                @Override
                public void onCancel() {

                    // on cancel
                    Toast.makeText(BIGShowsLoginActivity.this, "Facebook request cancelled", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(FacebookException error) {

                    Toast.makeText(BIGShowsLoginActivity.this,error.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
            });

        }else if(view == btnSignUp){


            // do the login procedure to create session
            submitForm();
        }
    }

    private void initGoogleApiClient() {

        mSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestIdToken(Constants.GOOGLE_SIGN_IN_CLIENT_ID)
                .requestProfile()
                .build();

        //initialise google api client
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,mSignInOptions)
                .build();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GOOGLE_SIGN_IN_REQUEST_CODE){
            //get result from intent data
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            Toast.makeText(getApplicationContext(), result.getSignInAccount().getEmail(),Toast.LENGTH_LONG).show();

            //Calling a new function to handle signin
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {

        if(result.isSuccess()){

            //first get google account
            final GoogleSignInAccount mGoogleSignInAccount = result.getSignInAccount();


        }else {
           Toast.makeText(getApplicationContext(),result.getStatus().toString(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }



    //Text watcher to look after validation of Fields
    private class LoginFieldTextWatcher implements TextWatcher {

        private View view;

        private LoginFieldTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.big_show_user_login_user_email_edittext:
                    validateEmail();
                    break;
                case R.id.big_show_user_login_user_password_edittext:
                    validatePassword();
                    break;
            }
        }
    }

    private boolean validateEmail() {
         userEmail = inputEmail.getText().toString().trim();

        if (userEmail.isEmpty() || !isValidEmail(userEmail)) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        userPassword = inputPassword.getText().toString().trim();
        if (userPassword.isEmpty()) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }



    /**
     * Validating form
     */
    private void submitForm() {

        if(validateEmail() && validatePassword()){

            // start server request to
            mLoginApiInterface = ApiClient.getRetrofitInstance().create(LoginApiInterface.class);
            Call<Token> call = mLoginApiInterface.getToken(Constants.API_KEY);
            call.enqueue(new retrofit2.Callback<Token>() {
                @Override
                public void onResponse(Call<Token> call, Response<Token> response) {

                    Toast.makeText(getApplicationContext(),response.body().getRequestToken(),Toast.LENGTH_LONG);

                    if(response.body().getSuccess()){

                        // do something here
                        //initiate user login with user name and password
                        final  LoginApiInterface mLoginApiInterface = ApiClient.getRetrofitInstance().create(LoginApiInterface.class);
                        Call<AuthenticatedToken> mAuthenticatedTokenCall = mLoginApiInterface.getAuthenticatedUserTokenOrSession(Constants.API_KEY,response.body().getRequestToken(),"Ajay1990",userPassword);
                        mAuthenticatedTokenCall.enqueue(new retrofit2.Callback<AuthenticatedToken>() {
                            @Override
                            public void onResponse(Call<AuthenticatedToken> call, Response<AuthenticatedToken> response) {

                                if(response.body().getSuccess()){
                                    BigShowsEntertainmentApp.getSingleInstance().setUserLoggedIN(true);
                                    BigShowsEntertainmentApp.getSingleInstance().setValidSessionID(response.body().getRequestToken());

                                    // get request for user profile and set user to home page
                                    final LoginApiInterface mUserProfileInterface = ApiClient.getRetrofitInstance().create(LoginApiInterface.class);
                                    Call<UserProfileDetail> mUserProfileCall = mUserProfileInterface.getUserProfileDetail(Constants.API_KEY,response.body().getRequestToken());
                                    mUserProfileCall.enqueue(new retrofit2.Callback<UserProfileDetail>() {
                                        @Override
                                        public void onResponse(Call<UserProfileDetail> call, Response<UserProfileDetail> response) {

                                            if(response.isSuccessful()){
                                                String name = response.body().getName();
                                                String userName = response.body().getUsername();
                                                // Start Activity for home page
                                                Intent intent = new Intent(BIGShowsLoginActivity.this, BigShowsHomeActivity.class);
                                                intent.putExtra("PROFILE_NAME",userName);
                                                intent.putExtra("USER_NAME",name);
                                                startActivity(intent);

                                            }
                                            else {
                                                Toast.makeText(getApplicationContext(),"retrieve user profile failed",Toast.LENGTH_LONG);
                                                Intent intent = new Intent(BIGShowsLoginActivity.this, BigShowsHomeActivity.class);
                                                /*intent.putExtra("PROFILE_NAME",userName);
                                                intent.putExtra("USER_NAME",name);*/
                                                startActivity(intent);
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<UserProfileDetail> call, Throwable t) {

                                        }
                                    });


                                }else{
                                   Toast.makeText(getApplicationContext(),"Invalied User Name or Password",Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<AuthenticatedToken> call, Throwable t) {

                            }
                        });
                    }

                }

                @Override
                public void onFailure(Call<Token> call, Throwable t) {

                }
            });
        }

    }

}
