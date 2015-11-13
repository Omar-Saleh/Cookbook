class Status < ActiveRecord::Base
	validate :that_atleast_one_field_is_present

	def that_atleast_one_field_is_present
		if self.description.nil? and self.pic.nil?
			errors.add(:description , "You have to upload a picture or write a status!")
		end
	end
end
