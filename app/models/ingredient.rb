class Ingredient < ActiveRecord::Base
	validates_numericality_of :qty, greater_than: 0
	validates :unit, :name, presence: true
	belongs_to :recipe
end
