package matrix.com.calcularimcteste;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private EditText editPeso;
    private EditText editAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.textResultado);  // indica que esta variável criada lá em cima vai ser lincada com o "id" nomeado na interface.
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Criar o nosso método:
    public void  calcularImc(View view){

        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double resultado = peso / (altura * altura);

        if (resultado < 19){
            textResultado.setText("Abaixo do peso.");
        }

        else if (resultado <= 19 || resultado < 25){
            textResultado.setText("Peso ideal.");
        }

        else if (resultado <= 25 || resultado < 30){
            textResultado.setText("Sobre peso.");
        }

        else if (resultado <= 30 || resultado < 40){
            textResultado.setText("Obesidade tipo 1.");
        }

        else if (resultado >= 40){
            textResultado.setText("Obesidade tipo 2.");
        }
    }
}