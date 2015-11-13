class Recipe < ActiveRecord::Base
	validates :description, :preparation, presence: true
end
