package com.gwtcalc.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;


public class CalcUiBinder extends Composite implements HasText {

	private static CalcUiBinderUiBinder uiBinder = GWT.create(CalcUiBinderUiBinder.class);

	interface CalcUiBinderUiBinder extends UiBinder<Widget, CalcUiBinder> {
	}

	@UiField VerticalPanel verticalPanel;
	@UiField TextBox textBox;
	@UiField Button btnClear;
	@UiField Button btnOne;
	@UiField Button btnDivide;
	@UiField Button btnMult;
	@UiField Button btnSub;
	@UiField Button btnAdd;
	@UiField Button btnAns;
	@UiField Button btnTwo; 
	@UiField Button btnThree;
	@UiField Button btnFour;
	@UiField Button btnFive;
	@UiField Button btnSix;
	@UiField Button btnSeven;
	@UiField Button btnEight;
	@UiField Button btnNine;
	@UiField Button btnZero;
	@UiField Button btnDot;

    private double firstValue = 0;
    private double lastResult = 0;
    private char lastOperator = ' ';

    public CalcUiBinder() {
        initWidget(uiBinder.createAndBindUi(this));
        textBox.setFocus(true);
        ButtonClickHandlers();
        textBoxValidation();
    }

    private void textBoxValidation() {
		textBox.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				char keyPress = event.getCharCode();
				if (!Character.isDigit(keyPress) && keyPress != '.' && keyPress != '+' && keyPress != '-' && keyPress != '*' && keyPress != '/' ) {
	                textBox.cancelKey();
	            }
			}
		});
	
		textBox.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if(event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					performOperation(lastOperator);
				}
			}
		});
	}

	private void ButtonClickHandlers() {
        btnClear.addClickHandler(event -> {
	            clearTextBox();
	            firstValue = 0;
	            lastOperator = ' ';
        });
  
        ClickHandler numberButton = event -> {
            Button button = (Button) event.getSource();
            String currentValue = textBox.getValue();
            
            if (currentValue.length() < 10) {
                textBox.setValue(currentValue + button.getText());
            }
        };
        
        btnOne.addClickHandler(numberButton);
        btnTwo.addClickHandler(numberButton);
        btnThree.addClickHandler(numberButton);
        btnFour.addClickHandler(numberButton);
        btnFive.addClickHandler(numberButton);
        btnSix.addClickHandler(numberButton);
        btnSeven.addClickHandler(numberButton);
        btnEight.addClickHandler(numberButton);
        btnNine.addClickHandler(numberButton);
        btnZero.addClickHandler(numberButton);
        btnDot.addClickHandler(numberButton);
        btnAdd.addClickHandler(numberButton);
        btnSub.addClickHandler(numberButton);
        btnMult.addClickHandler(numberButton);
        btnDivide.addClickHandler(numberButton);
        btnAns.addClickHandler(new ClickHandler() {
	    	@Override
			public void onClick(ClickEvent event) {
	    		performOperation(lastOperator);
	        }
        }); 
    }
	
    private void clearTextBox() {
        textBox.setText("");
    }
		
    native void console( String message) /*-{
    	console.log(message );
	}-*/;

    private void performOperation(char operator) {
		String input = textBox.getText();
		String[] parts = input.split("\\D+");
    	
    	double firstValue = Double.parseDouble(parts[0]);
        double secondValue = Double.parseDouble(parts[1]);
        char op = input.charAt(parts[0].length());
        double result = 0;

        switch (op) {
            case '+':
            	 console("fv :"  + firstValue);
                 console("sv :"  + secondValue);
                 console("operator "+ op);
                result  = firstValue + secondValue;
                console("result : "+ result);
                break;
            case '-':
                result = firstValue - secondValue;
                break;
            case '*':
                result = firstValue * secondValue;
                break;
            case '/':
                if (secondValue != 0) {
                    result = firstValue / secondValue;
                } else {
                    textBox.setValue("Cannot divide by zero");
                    return;
                }
                break;
            default:
                result = secondValue;       
        }
        // Display result in the text box
        firstValue = result;
        lastResult = result;
        textBox.setValue(String.valueOf(lastResult));
        lastOperator = op;
    }

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}
}
