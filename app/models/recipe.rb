class Recipe < Post

	validates :description, :preparation, presence: true
end
