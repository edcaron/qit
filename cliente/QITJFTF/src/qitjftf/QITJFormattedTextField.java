package qitjftf;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author eduar_000
 */
public class QITJFormattedTextField extends JFormattedTextField {

    private String dataType;
    private boolean notNull;
    private int maxLenght;
    private boolean isValid;    
    private Color colorError = Color.CYAN;
    private Color colorDefault = Color.white;

    private final Color COLOR_EDITABLE_FALSE = new Color(240,240,240);
    private final String CPF_MASK = "###.###.###-##";
    private final String PHONE_MASK = "(##) ####-####";
    private final String CNPJ_MASK = "##.###.###/####-##";
    private final String DATE_MASK = "##/##/####";
    private final String TIMESTAMP_MASK = "##/##/#### ##:##:##";

    public QITJFormattedTextField() {
        contrucaoPadrao();
    }

    public QITJFormattedTextField(String dataType, int maxLenght, boolean notNull) {
        this.dataType = dataType;
        this.notNull = notNull;
        this.maxLenght = maxLenght;
        applyMask();
        contrucaoPadrao();
    }

    private void contrucaoPadrao() {
        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
//                validateDataType();
            }
        });
    }

    public void applyMask() {
        String mask = null;

        //decide qual mascara deve inserir no campo com base no tipo do campo
        switch (this.dataType) {
            case "cpf":
                mask = CPF_MASK;
                break;
            case "cnpj":
                mask = CNPJ_MASK;
                break;
            case "date":
                mask = DATE_MASK;
                break;
            case "timestamp":
                mask = TIMESTAMP_MASK;
                break;
            case "phone":
                mask = PHONE_MASK;
                break;
        }

        if (this.getDataType() != "text" && this.getDataType() != "integer") {
            //aplica mascara no campo
            try {
                MaskFormatter m = new MaskFormatter();
                m.setPlaceholder(null);
                m.setMask(mask);
                this.setFormatterFactory(null);
                this.setFormatterFactory(new DefaultFormatterFactory(m));
                this.setValue(null);
//            this.setFocusLostBehavior(JFormattedTextField.PERSIST); //essa propriedade permite que seja ignorado o comprimento da mascara            

            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public void validateDataType() {
        boolean valido = true;        
        try {
            //verificar se pode ser nulo
            if (this.isNotNull() && this.getText().trim().isEmpty()) {
                System.out.println("Não pode ser nulo");
                JOptionPane.showMessageDialog(null, "Este campo não pode ficar vazio");
                valido = false;
            }
//        verificar se e do tipo int e contem numeros
            if (this.getDataType().equals("integer") && apenasNumeros()) {
                System.out.println("tem letras no int");
                JOptionPane.showMessageDialog(null, "Este campo pode conter apenas números");
                valido = false;
            }

            if (this.getText().trim().length() > this.getMaxLenght()) {
                System.out.println("excedeu o tamanho");
                JOptionPane.showMessageDialog(null, "Este campo excedeu o tamanho máximo permitido.\nO tamanho máximo é " + this.getMaxLenght());
                valido = false;
            }

            if (valido) {
                this.setIsValid(true);
            } else {
                this.setIsValid(false);
            }
        } catch (Exception e) {
            System.err.println("Erro em validateDataType" + e);
        }
    }

    private void setBackgroundIfInvalid() {
        try {
            if (isValid) {
                if (this.isEditable()) {
                    this.setBackground(colorDefault);
                } else {
                    this.setBackground(COLOR_EDITABLE_FALSE);
                }
                System.out.println("validou");
            } else {
                System.out.println("invalidou");
                this.setBackground(colorError);
            }
        } catch (Exception e) {
            System.err.println("Erro ao mudar a cor do jftf :" + e);
        }
    }

    private boolean apenasNumeros() {
        boolean invalido = false;
        try {
            String texto = this.getText();
            for (int i = 0; ((i < texto.length()) && !invalido); i++) {
                char a = texto.charAt(i);
                if ((a == '0') || (a == '1') || (a == '2') || (a == '3') || (a == '4') || (a == '5') || (a == '6') || (a == '7') || (a == '8') || (a == '9')) {
                } else {
                    invalido = true;
                }
            }
        } catch (Exception e) {
            System.err.println("Erro em apenasNumeros" + e);
        }
        return invalido;
    }

    public Color getColorError() {
        return colorError;
    }

    public void setColorError(Color colorError) {
        this.colorError = colorError;
    }

    public Color getColorDefault() {
        return colorDefault;
    }

    public void setColorDefault(Color colorDefault) {
        this.colorDefault = colorDefault;
    }

    public boolean isIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
        setBackgroundIfInvalid();//mudar a cor do plano de fundo quando mudar esse atributo
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public int getMaxLenght() {
        return maxLenght;
    }

    public void setMaxLenght(int maxLenght) {
        this.maxLenght = maxLenght;
    }

}
