class SessionsController < ApplicationController
	before_filter :session_params
	skip_before_filter  :verify_authenticity_token

	def create
		@user = User.authenticate(*session_params.values_at(:token, :username))
		render json: @user.to_json
	end
	
private
	def session_params
		params.require(:session).permit(:token, :username)
	end
end