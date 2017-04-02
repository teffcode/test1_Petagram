package com.coursera.tefa.appmascotas.menu;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.coursera.tefa.appmascotas.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ActivityMenuContacto extends AppCompatActivity {

    Session session;
    EditText input_nombre, input_correo, input_mensaje;
    Button boton_enviar;
    String nombre, correo, mensaje, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_contacto);

        iniciar();

        boton_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nombre = input_nombre.getText().toString();
                correo = input_correo.getText().toString();
                mensaje = input_mensaje.getText().toString();

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");

                try {
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo,contraseña);
                        }
                    });

                    if (session != null) {
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject(nombre);
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("tefy.1@live.com"));
                        message.setContent(mensaje, "text/html; charset=utf-8");
                        Transport.send(message);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


        });
    }

    public void iniciar() {
        input_nombre = (EditText) findViewById(R.id.input_nombre);
        input_correo = (EditText) findViewById(R.id.input_correo);
        input_mensaje = (EditText) findViewById(R.id.input_mensaje);
        boton_enviar = (Button) findViewById(R.id.boton_enviar_email);
    }

}
