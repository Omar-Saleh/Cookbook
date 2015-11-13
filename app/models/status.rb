<<<<<<< HEAD
class Status < Post
	mount_uploader :picture, PictureUploader
	validate :that_atleast_one_field_is_present
=======
class MyValidator < ActiveModel::Validator
  def validate(record)
    if record.description.nil?
      record.errors[:description] << 'description can not be nil'
    end
  end
end

class Status < ActiveRecord::Base
  	include ActiveModel::Validations
  	validates_with MyValidator
>>>>>>> ab414010acc11f739d36aedcd4450514914b6f76

	# def image_and_text_not_null
	# 	if(self.description == null )
end