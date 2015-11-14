
class MyValidator < ActiveModel::Validator
  def validate(record)
    if record.description.blank? and record.picture.blank?
      record.errors[:description] << 'description can not be nil'
    end
  end
end

class Status < ActiveRecord::Base
  	include ActiveModel::Validations
  	mount_uploader :picture, PictureUploader
  	validates_with MyValidator
  	acts_as_commentable
  	acts_as_votable
end