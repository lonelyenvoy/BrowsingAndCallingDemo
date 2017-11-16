package ink.envoy.browsingandcallingdemo;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class BrowseActivity extends AppCompatActivity {

    private EditText urlEditText;
    private WebView webView;
    private Button visitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        initialize();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initialize() {
        bindViews();

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });
        visitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(urlEditText.getText().toString());
            }
        });
    }

    private void bindViews() {
        urlEditText = (EditText) findViewById(R.id.urlEditText);
        webView = (WebView) findViewById(R.id.webView);
        visitButton = (Button) findViewById(R.id.visitButton);
    }
}
