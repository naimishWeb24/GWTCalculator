package com.gwtcalc.client;


import com.gargoylesoftware.htmlunit.javascript.host.Window;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;


import com.google.gwt.user.client.ui.RootPanel;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class GwtCalculator implements EntryPoint {
    private static CalcUiBinder uiBinder = GWT.create(CalcUiBinder.class);
    
    
	public void onModuleLoad() {
		CalcUiBinder calculatorWidget = new CalcUiBinder();
		RootPanel.get().add(calculatorWidget);
		calculatorWidget.textBox.setFocus(true);

//		final Button btnClear = new Button("clear");
//		final Button btnOne = new Button("1");
//		final Button btnTwo = new Button("2");
//		final Button btnThree = new Button("3");
//		final Button btnFour = new Button("4");
//		final Button btnFive = new Button("5");
//		final Button btnSix = new Button("6");
//		final Button btnSeven = new Button("7");
//		final Button btnEight = new Button("8");
//		final Button btnNine = new Button("9");
//		final Button btnZero = new Button("0");
//		final Button btnDiv = new Button("/");
//		final Button btnMult = new Button("*");
//		final Button btnSub = new Button("-");
//		final Button btnAdd = new Button("+");
//		final Button btnAns = new Button("=");
//		final Button btnDot = new Button(".");
//		final TextBox txtBox = new TextBox();
//		txtBox.setText("0");

		// We can add style names to widgets
//		add.addStyleName("Button");
//		sub.addStyleName("Button");
//		mul.addStyleName("Button");
//		div.addStyleName("Button");
//		

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
//		RootPanel.get("txtContainer").add(txtBox);
//		RootPanel.get("btnClear").add(btnClear);
//		RootPanel.get("btnSeven").add(btnSeven);
//		RootPanel.get("btnEight").add(btnEight);
//		RootPanel.get("btnNine").add(btnNine);
//		RootPanel.get("btnDivide").add(btnDiv);
//		RootPanel.get("btnFour").add(btnFour);
//		RootPanel.get("btnFive").add(btnFive);
//		RootPanel.get("btnSix").add(btnSix);
//		RootPanel.get("btnMult").add(btnMult);
//		RootPanel.get("btnOne").add(btnOne);
//		RootPanel.get("btnTwo").add(btnTwo);
//		RootPanel.get("btnThree").add(btnThree);
//		RootPanel.get("btnSub").add(btnSub);
//		RootPanel.get("btnZero").add(btnZero);
//		RootPanel.get("btnDot").add(btnDot);
//		RootPanel.get("btnAns").add(btnAns);
//		RootPanel.get("btnAdd").add(btnAdd);
//		
		
//		RootPanel.get().add(new CalcUiBinder());
		

		// Focus the cursor on the name field when the app loads
//		txtBox.setFocus(true);
		

		// Create the popup dialog box
//		final DialogBox dialogBox = new DialogBox();
//		dialogBox.setText("Remote Procedure Call");
//		dialogBox.setAnimationEnabled(true);
//		final Button closeButton = new Button("Close");
//		// We can set the id of a widget by accessing its Element
//		closeButton.getElement().setId("closeButton");
//		final Label textToServerLabel = new Label();
//		final HTML serverResponseLabel = new HTML();
//		VerticalPanel dialogVPanel = new VerticalPanel();
//		dialogVPanel.addStyleName("dialogVPanel");
//		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
//		dialogVPanel.add(textToServerLabel);
//		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
//		dialogVPanel.add(serverResponseLabel);
//		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
//		dialogVPanel.add(closeButton);
//		dialogBox.setWidget(dialogVPanel);

//		// Add a handler to close the DialogBox
//		closeButton.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				dialogBox.hide();
//				sendButton.setEnabled(true);
//				sendButton.setFocus(true);
//			}
//		});

		// Create a handler for the sendButton and nameField
//		class MyHandler implements ClickHandler, KeyUpHandler {
//			/**
//			 * Fired when the user clicks on the sendButton.
//			 */
//			public void onClick(ClickEvent event) {
//				sendNameToServer();
//			}
//
//			/**
//			 * Fired when the user types in the nameField.
//			 */
//			public void onKeyUp(KeyUpEvent event) {
//				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
//					sendNameToServer();
//				}
//			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
//			private void sendNameToServer() {
//				// First, we validate the input.
//				errorLabel.setText("");
//				String textToServer = nameField.getText();
//				if (!FieldVerifier.isValidName(textToServer)) {
//					errorLabel.setText("Please enter at least four characters");
//					return;
//				}
//
//				// Then, we send the input to the server.
//				sendButton.setEnabled(false);
//				textToServerLabel.setText(textToServer);
//				serverResponseLabel.setText("");
//				greetingService.greetServer(textToServer, new AsyncCallback<String>() {
//					public void onFailure(Throwable caught) {
//						// Show the RPC error message to the user
//						dialogBox.setText("Remote Procedure Call - Failure");
//						serverResponseLabel.addStyleName("serverResponseLabelError");
//						serverResponseLabel.setHTML(SERVER_ERROR);
//						dialogBox.center();
//						closeButton.setFocus(true);
//					}
//
//					public void onSuccess(String result) {
//						dialogBox.setText("Remote Procedure Call");
//						serverResponseLabel.removeStyleName("serverResponseLabelError");
//						serverResponseLabel.setHTML(result);
//						dialogBox.center();
//						closeButton.setFocus(true);
//					}
//				});
//			}
//		}
//
//		// Add a handler to send the name to the server
//		MyHandler handler = new MyHandler();
//		sendButton.addClickHandler(handler);
//		nameField.addKeyUpHandler(handler);
	}
}
