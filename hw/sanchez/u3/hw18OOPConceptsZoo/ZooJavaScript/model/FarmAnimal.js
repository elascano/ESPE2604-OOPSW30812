const mongoose = require('mongoose');

const farmAnimalSchema = new mongoose.Schema({
  id: { type: Number, required: true, unique: true },
  type: { type: String, required: true },
  breed: { type: String, required: true },
  bornOn: { type: Date, required: true },
  weight: { type: Number, required: true },
  registeredAt: { type: Date, default: Date.now },
  isProducingMilk: { type: Boolean, default: false },
  milkProduced: { type: Number, default: 0 },
  isMolting: { type: Boolean, default: false },
  numberOfEggsPerWeek: { type: Number, default: 0 },
  idealWeight: { type: Number, default: 0 },
  lastSheering: { type: Date }
}, { collection: 'animals' });

farmAnimalSchema.virtual('ageInMonths').get(function() {
  if (!this.bornOn) return 0;
  const now = new Date();
  const diff = now - this.bornOn;
  return Math.floor(diff / (1000 * 60 * 60 * 24 * 30));
});

farmAnimalSchema.set('toJSON', { virtuals: true });
farmAnimalSchema.set('toObject', { virtuals: true });

module.exports = mongoose.model('FarmAnimal', farmAnimalSchema);