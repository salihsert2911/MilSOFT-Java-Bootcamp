import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { Menu } from "primereact/menu";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";

export default function CategoriesComponent() {
  let navigate = useNavigate();
  const url = "http://localhost:8080/categories";

  const [categories, setCategories] = useState([]);

  useEffect(() => {
    axios.get(url).then((response) => {
      setCategories(response.data);
    });
  }, []);

  const categoryItems = categories.map((category) => ({
    label: category.categoryName,
    icon: "pi pi-shopping-bag",
    command: () => {
      navigate("/products/" + category.categoryId);
    },
  }));

  const items = [
    {
      label: "Home",
      icon: "pi pi-home",
      command: () => {
        navigate("/");
      },
    },
    {
      label: "Cart",
      icon: "pi pi-shopping-cart",
      command: () => {
        navigate("/cart");
      },
    },
    {
      label: "Categories",
      items: categoryItems,
    },
  ];

  return (
    <div className="card flex category-menu">
      <Menu model={items} />
    </div>
  );
}
