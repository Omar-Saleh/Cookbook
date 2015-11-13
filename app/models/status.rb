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

	# def image_and_text_not_null
	# 	if(self.description == null )
end