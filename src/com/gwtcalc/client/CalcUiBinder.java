package com.gwtcalc.client;

import java.util.ArrayList;
import java.util.List;
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

	// Constructor
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
					performOperation();
				}
			}
		});
	}

	private void ButtonClickHandlers() {                                                                         
        btnClear.addClickHandler(event -> {
	            clearTextBox();   
        });
  
        ClickHandler numberButton = event -> {
            Button button = (Button) event.getSource();
            String currentValue = textBox.getValue();
            
            if (currentValue.length() < 15) {
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
	    		performOperation();
	        }
        }); 
    }
	
	// Clear-button Method
    private void clearTextBox() {																						
        textBox.setText("");
    }
		
    native void console( String message) /*-{																			// native method for print data in console
    	console.log(message );
	}-*/;
    
//    inbuilt eval method for evaluate , Calculate numbers     
//    native double eval( String message) /*-{																			
//		return eval(message);
//	}-*/;

    private void performOperation() {																					
    	double result = 0;
    	try {
				String input = textBox.getText(); 										
				console("input String : "+ input);
				//double answer = eval(input);
				
				String[] elements = input.split("[^0-9.]");
				List<Double> values = new ArrayList<Double>();   							
				for(int i=0; i<elements.length; i++) {
					values.add(Double.parseDouble(elements[i]));
				}
				console("values" + values );
				
				List<Character> operators = new ArrayList<>();
				for (char c : input.toCharArray()) {
				    if (c == '+' || c == '-' || c == '*' || c == '/') {
				        operators.add(c);
				    }
				}
				console("operators:" + operators);
				
				// Perform multiplication and division first
				for (int index = 0; index < operators.size(); index++) {
					char operator = operators.get(index);
					if (operator == '/' || operator == '*') {
			             if (operator == '/') {
			                 result = values.get(index) / values.get(index + 1);
			             } else {
			                 result = values.get(index) * values.get(index + 1);
			             }
			             values.set(index, result);
			             values.remove(index + 1);
			             operators.remove(index);
			             index--;
			             console("operators:" + operators);
			             console("Values : " + values);
					}
				}
		     
				// Perform addition and subtraction
				result = values.get(0);
				for (int i = 0; i < operators.size(); i++) {
					char operator = operators.get(i);
		         
					if (operator == '+') {
						result += values.get(i + 1);
					} else if (operator == '-') {
			             result -= values.get(i + 1);
					}
					console("operators:" + operators);
					console("Values : " + values);
			     }
				console("result : " + result);
				textBox.setText(String.valueOf(result));
			} catch (Exception e) {
				textBox.setText("Malformed expression");
			}
    }

	@Override
	public String getText() {
		return null;
	}

	@Override
	public void setText(String text) {
		
	}

	
}
