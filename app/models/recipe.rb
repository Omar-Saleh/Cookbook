class Recipe < Post
	mount_uploader :picture, PictureUploader
	validates :description, :preparation, presence: true
end
