<<<<<<< HEAD
class Recipe < Post
	mount_uploader :picture, PictureUploader
=======
class Recipe < ActiveRecord::Base

>>>>>>> ab414010acc11f739d36aedcd4450514914b6f76
	validates :description, :preparation, presence: true
end
