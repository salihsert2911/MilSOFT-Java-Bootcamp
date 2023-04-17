import React, { useState, useEffect, useRef } from "react";
import { useParams } from "react-router-dom";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import { InputNumber } from "primereact/inputnumber";
import { Toast } from "primereact/toast";
import { Button } from "primereact/button";
import { Card } from "primereact/card";
import axios from "axios";

export default function ProductComponent() {
  const { id } = useParams();
  const [product, setProduct] = useState({});
  const [value, setValue] = useState(1);
  const url = "http://localhost:8080/product/" + id;
  const toast = useRef(null);
  const baseImgPath = "../../../img/";

  useEffect(() => {
    axios.get(url).then((response) => {
      setProduct(response.data);
    });
  }, [url]);

  const addToCart = (product) => {
    const url = "http://localhost:8080/cart/add/1/" + product.productId;
    axios
      .post(url, {
        salesQuantity: value,
      })
      .then((response) => {
        if (response.status === 200) {
          toast.current.show({
            severity: "success",
            summary: "Success",
            detail: "The product added to cart.",
            life: 3000,
          });
        } else {
          toast.current.show({
            severity: "error",
            summary: "Error",
            detail: "The product could not be added to the cart.",
            life: 3000,
          });
        }
      });
  };

  return (
    <div className="card justify-content-center product-item">
      <Toast ref={toast}></Toast>
      <Card
        title={product.productName}
        footer={
          <div className="card-footer-elements">
            <InputNumber
              value={value}
              onValueChange={(e) => setValue(e.value)}
              showButtons
              buttonLayout="vertical"
              style={{ width: "3rem" }}
              decrementButtonClassName="p-button-secondary"
              incrementButtonClassName="p-button-secondary"
              incrementButtonIcon="pi pi-plus"
              decrementButtonIcon="pi pi-minus"
              min={1}
            />
            <Button
              label={product.salesPrice?.toFixed(2)}
              icon="pi pi-dollar"
              severity="success"
            />
            <Button
              label={(product.salesPrice * value)?.toFixed(2)}
              icon="pi pi-dollar"
              severity="help"
            />

            <Button
              label="Add To Cart"
              icon="pi pi-shopping-cart"
              onClick={() => addToCart(product)}
            />
          </div>
        }
        header={<img alt="Card" src={baseImgPath + product.imgPath} />}
      ></Card>
    </div>
  );
}
