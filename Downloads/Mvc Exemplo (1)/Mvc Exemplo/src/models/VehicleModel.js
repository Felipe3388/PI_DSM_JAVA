class VehicleModel {

    constructor() {
        this.vehicles = []
    }

    getAll() {
        return this.vehicles
    }

    create(brand, model) {

        const vehicle = {
            id: Date.now().toString(),
            brand,
            model,
            available: true
        }

        this.vehicles.push(vehicle)

        return vehicle
    }

    findById(id) {
        return this.vehicles.find(v => v.id === id)
    }

}

module.exports = new VehicleModel()