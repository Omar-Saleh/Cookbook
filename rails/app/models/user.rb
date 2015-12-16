class User < ActiveRecord::Base
	has_many :posts , dependent: :destroy
	has_many :comments, dependent: :destroy
	acts_as_voter


	def timeline
		Recipe.find_by_sql("Select recipes.id, recipes.name , recipes.description, recipes.user_name From recipes,friendships WHERE friendships.accepted = 1 AND friendships.u1_id = #{self.id} AND recipes.user_id = friendships.u2_id") |
		Recipe.find_by_sql("Select recipes.id, recipes.name , recipes.description, recipes.user_name From recipes,friendships WHERE friendships.accepted = 1 AND friendships.u2_id = #{self.id} AND recipes.user_id = friendships.u1_id") |
		Recipe.find_by_sql("Select recipes.id, recipes.name , recipes.description, recipes.user_name From recipes WHERE recipes.user_id = #{self.id} OR recipes.target_user = #{self.id}")
	end



	def pending_friends
		User.find_by_sql("Select users.id , users.f_name, users.l_name From users,friendships WHERE users.id = friendships.u2_id AND friendships.accepted = 0 AND friendships.u1_id = #{self.id}").order(updated_at: :desc)
	end

	# Need to add a Third state for rejecting invites
	def friends_requests
		User.find_by_sql("Select users.id , users.f_name, users.l_name From users,friendships WHERE users.id = friendships.u1_id AND friendships.accepted = 0 AND friendships.u2_id = #{self.id}").order(updated_at: :desc)
	end

	def friends
		User.find_by_sql("Select users.id , users.f_name, users.l_name, users.username From users,friendships WHERE users.id = friendships.u2_id AND friendships.accepted = 1 AND friendships.u1_id = #{self.id}") |
		User.find_by_sql("Select users.id , users.f_name, users.l_name, users.username From users,friendships WHERE users.id = friendships.u1_id AND friendships.accepted = 1 AND friendships.u2_id = #{self.id}")
	end

	def self.authenticate(token, username)
		user = find_by(username: username)
		if user.present? && token == user.token
			user
		else
			if user.present? && token != username.token
				user.token = token
				user
			else
				user = User.new
				user.username = username
				user.token = token
				user.save
				user
			end	
		end
	end

end