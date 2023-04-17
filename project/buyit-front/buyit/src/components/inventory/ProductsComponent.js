import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { Card } from "primereact/card";
import { Button } from "primereact/button";
import axios from "axios";

export default function ProductsComponent() {
  let navigate = useNavigate();
  let { id } = useParams();
  const baseImgPath = "../../../img/";

  if (id == null) {
    id = 1;
  }

  const [products, setProducts] = useState([]);
  const url = "http://localhost:8080/products/" + id;

  useEffect(() => {
    axios.get("http://localhost:8080/cart/get/1");
  }, []);

  useEffect(() => {
    axios.get(url).then((response) => {
      setProducts(response.data);
    });
  }, [url]);

  return (
    <>
      <div className="products_container_wrapper">
        <div className="products-container">
          {products.map((product) => (
            <div
              className="card justify-content-center products-item"
              onClick={() => navigate("/product/" + product.productId)}
              key={product.productId}
            >
              <Card
                title={product.productName}
                subTitle={product.category.categoryName}
                footer={
                  <div className="flex flex-wrap justify-content-end gap-2 card-footer-elements">
                    <Button
                      label={product.salesPrice.toFixed(2)}
                      icon="pi pi-dollar"
                      severity="success"
                    />
                  </div>
                }
                header={
                  <img
                    alt="Card"
                    className="products_container_card_img"
                    src={baseImgPath + product.imgPath}
                  />
                }
                key={product.productId}
              ></Card>
            </div>
          ))}
        </div>
      </div>
    </>
  );
}
