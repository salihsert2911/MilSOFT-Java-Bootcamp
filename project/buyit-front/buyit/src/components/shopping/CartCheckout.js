import React, { useState, useEffect } from "react";
import { InputText } from "primereact/inputtext";
import { Button } from "primereact/button";
import { useNavigate } from "react-router-dom";
import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import axios from "axios";

export default function CartCheckout() {
  let navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [cardNumber, setCardNumber] = useState("");
  const [cart, setCart] = useState({});
  const url = "http://localhost:8080/cart/get/1";
  useEffect(() => {
    axios.get(url).then((response) => {
      setCart(response.data);
    });
  }, []);

  const checkout = () => {
    const url = "http://localhost:8080/cart/checkout";
    cart.customerName = username;
    cart.cardNumber = cardNumber;
    cart.cartStatus = "COMPLETED";
    axios.put(url, cart).then((response) => {
      console.log(response);
      if (response.status === 200) {
        navigate("/");
      }
    });
  };

  return (
    <div className="checkout-container">
      <h1 style={{ color: "#005792", textAlign: "center" }}>User Info</h1>
      <div className="username">
        <InputText
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          placeholder="Username"
        />
      </div>
      <div className="card-number">
        <InputText
          value={cardNumber}
          onChange={(e) => setCardNumber(e.target.value)}
          placeholder="Card Number"
        />
      </div>
      <div className="confirm-button">
        <Button
          label="Confirm"
          severity="info"
          onClick={() => checkout()}
        ></Button>
      </div>
    </div>
  );
}
