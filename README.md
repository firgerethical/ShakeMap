# 🌍 Earthquake & Report API Client (Retrofit)

Este proyecto Android está diseñado para consumir una API REST relacionada con **terremotos** y **reportes sísmicos**. Utilizamos **Retrofit** como cliente HTTP para una integración eficiente, segura y escalable.

---

## 🧰 Tecnologías utilizadas

- 📱 **Android (Java/Kotlin)**
- 🔗 **Retrofit** - Cliente HTTP para Android y Java.
- 🧪 **Gson** (u otra librería de serialización) para el parseo de datos JSON.
- 🧾 **Logcat** para depuración de datos que no se muestran en la UI.

---

## 🔗 Rutas de la API

Las siguientes rutas están disponibles para su consumo mediante Retrofit:

| Método | Endpoint | Descripción | UI / Logcat |
|--------|----------|-------------|-------------|
| `GET` | `/parameter_reports/` | Devuelve una lista de reportes sísmicos. | ✅ UI |
| `GET` | `/earthquakes/` | Devuelve una lista de terremotos. | ✅ UI |
| `GET` | `/earthquakes/{eq_id}` | Devuelve el detalle de un terremoto (por ID). | 🔍 Logcat |
| `GET` | `/parameter_reports/{report_id}` | Devuelve el detalle de un reporte (por ID). | 🔍 Logcat |
| `GET` | `/parameter_reports/earthquake/{eq_id}` | Devuelve los reportes asociados a un terremoto. | 🔍 Logcat |

---

📲 Visualización de datos

🚧 Estado del proyecto

🟢 En desarrollo
✅ Retrofit implementado
🚀 API CONSUMIDA
