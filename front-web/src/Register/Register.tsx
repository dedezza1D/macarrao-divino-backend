import React from "react";
import { render } from "react-dom";
import { useForm } from "react-hook-form";

import "./Register.css";

type FormData = {
  nome: string;
  sobrenome: string;
  email: string;
  endereco: string;
  telefone: string
};

export default function Register() {
  const { register, handleSubmit } = useForm<FormData>();
  const onSubmit = handleSubmit(({ nome, sobrenome, email, endereco, telefone }) => {
     alert("Cadastro realizado com sucesso!")
     window.location.href='/login'
  }); // firstName and lastName will have correct type

  return (
    <form onSubmit={onSubmit}>
      <label>Nome</label>
      <input name="Nome" />
      <label>Email</label>
      <input name="Email" />
      <label>Senha</label>
      <input type="password"/>
      <label>Endereco</label>
      <input name="Endereço"/>
      <label>Telefone</label>
      <input name="Telefone"/>
      <input type="submit" />
    </form>
  );
}

const rootElement = document.getElementById("root");
render(<Register />, rootElement);
