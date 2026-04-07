const OrderModel = require("../models/OrderModel")
const ClientModel = require("../models/ClientModel")
const VehicleModel = require("../models/VehicleModel")

class OrderController {

    list(req, res) {

        const orders = OrderModel.getAll()

        const clients = ClientModel.getAll()

        const vehicles = VehicleModel.getAll()

        res.render("orders", { orders, clients, vehicles })
    }

    create(req, res) {

        const { clientId, vehicleId } = req.body

        OrderModel.create(clientId, vehicleId)

        res.redirect("/orders")
    }
}

module.exports = new OrderController()