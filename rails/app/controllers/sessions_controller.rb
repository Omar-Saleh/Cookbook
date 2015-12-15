class SessionsController < ApplicationController
	before_filter :find_model

	def create
		render json: User.authenticate(*session_params.values_at(:token)).to_json
	end

private
	def find_model
		params.require(:session).permit(:token)
	end
end