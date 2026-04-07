const VehicleModel = require("../models/VehicleModel")

class VehicleController {

    list(req, res) {

        const vehicles = VehicleModel.getAll()

        res.render("vehicles", { vehicles })
    }

    create(req, res) {

        const { brand, model } = req.body

        VehicleModel.create(brand, model)

        res.redirect("/vehicles")
    }

}

module.exports = new VehicleController()