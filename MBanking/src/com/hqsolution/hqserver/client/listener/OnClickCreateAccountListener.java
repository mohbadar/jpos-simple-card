package com.hqsolution.hqserver.client.listener;

import com.hqsolution.hqserver.app.dto.AccountLogin;
import com.hqsolution.hqserver.client.activity.CreateAccountActivity;
import com.hqsolution.hqserver.client.common.FinancialRequest;
import com.hqsolution.hqserver.client.common.FinancialRequestFacade;

import android.accounts.Account;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class OnClickCreateAccountListener implements View.OnClickListener,
		Runnable {

	private CreateAccountActivity activity;

	public OnClickCreateAccountListener(CreateAccountActivity activity) {
		super();
		this.activity = activity;
	}

	public void run() {
		FinancialRequest facade = FinancialRequestFacade.getInstance();
		AccountLogin login = new AccountLogin();
		login.setFullname(activity.getName().getText().toString());
		login.setEmail(activity.getEmail().getText().toString());
		login.setPassword(activity.getPassword().getText().toString());
		if(facade.saveUserInfo(login)){
			//save user info into phone
			activity.save(login);
		}
		// close dialog
		activity.getProgressDialog().dismiss();
	}

	public void onClick(View v) {
		ProgressDialog pd = activity.showProgressDialog();
		ProgressBar bar = new ProgressBar(activity);
		pd.addContentView(bar, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		Thread thread = new Thread(this);
		thread.start();
	}
}
