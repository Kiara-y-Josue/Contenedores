package com.example.myapplicationconten;


    public class Alumno {
        private String Nombre;
        private String Correo;
        public Alumno(String nombre, String
                correo){
            Nombre = nombre;
            Correo = correo;
        }
        public String getNombre(){
            return Nombre;
        }
        public String getCorreo(){
            return Correo;
        }
    }

