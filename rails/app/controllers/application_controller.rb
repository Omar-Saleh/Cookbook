class ApplicationController < ActionController::Base
  # Prevent CSRF attacks by raising an exception.
  # For APIs, you may want to use :null_session instead.
  protect_from_forgery with: :exception
end

protected 
	
	def current_user
		@current_user ||= User.find_by(id: session[:user_id])
	end

	helper_method :current_user

	def current_user?
		current_user.present?
	end

	helper_method :current_user?

	def authenticate_user!
		unless current_user?
			render status: :unauthorized
		end
	end


end